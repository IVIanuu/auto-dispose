/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.autodispose.android

import android.view.View
import com.ivianuu.autodispose.LifecycleNotStartedException
import com.ivianuu.autodispose.ScopeProvider
import io.reactivex.Completable

/**
 * A [ScopeProvider] for [View]'s
 */
class ViewScopeProvider(private val view: View) : ScopeProvider {

    override fun requestScope(): Completable {
        val isAttached = view.isAttached

        if (!isAttached) {
            throw LifecycleNotStartedException()
        }

        return Completable.create { e ->
            val listener = object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                }

                override fun onViewDetachedFromWindow(v: View) {
                    if (!e.isDisposed) {
                        e.onComplete()
                    }
                }
            }

            e.setCancellable { view.removeOnAttachStateChangeListener(listener) }

            view.addOnAttachStateChangeListener(listener)
        }
    }
}

fun View.scope(): ScopeProvider = ViewScopeProvider(this)