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

import android.app.Activity
import android.app.Dialog
import android.view.View
import com.ivianuu.autodispose.LifecycleScopeProvider
import com.ivianuu.autodispose.ScopeProvider
import com.ivianuu.autodispose.ScopeProviders
import com.ivianuu.autodispose.autoDispose
import io.reactivex.disposables.Disposable

fun ScopeProviders.from(activity: Activity): LifecycleScopeProvider<ActivityEvent> {
    return ActivityLifecycleScopeProvider.from(activity)
}

fun ScopeProviders.from(dialog: Dialog): ScopeProvider {
    return DialogScopeProvider.from(dialog)
}

fun ScopeProviders.from(view: View): ScopeProvider {
    return ViewScopeProvider.from(view)
}

fun Activity.scope() = ScopeProviders.from(this)

fun Dialog.scope() = ScopeProviders.from(this)

fun View.scope() = ScopeProviders.from(this)

fun Disposable.autoDispose(activity: Activity) {
    autoDispose(ScopeProviders.from(activity))
}

fun Disposable.autoDispose(dialog: Dialog) {
    autoDispose(ScopeProviders.from(dialog))
}

fun Disposable.autoDispose(view: View) {
    autoDispose(ScopeProviders.from(view))
}