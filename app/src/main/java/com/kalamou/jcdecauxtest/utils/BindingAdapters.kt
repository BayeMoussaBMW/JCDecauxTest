/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kalamou.jcdecauxtest.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kalamou.jcdecauxtest.model.StationsItem
import com.kalamou.jcdecauxtest.ui.StationGridAdapter

/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<StationsItem>?) {
    val adapter = recyclerView.adapter as StationGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("latitude")
fun bindText(textView: TextView?, tv: List<StationsItem>?) {
    tv?.let {
        for (i in tv) {
            textView?.text = i.position.latitude.toString()
        }
    }
}


@BindingAdapter("text")
fun bindSecondText(textView: TextView?, tv: StationsItem?) {
    tv?.let {
        textView?.text = tv.status
    }
}

