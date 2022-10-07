/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1,R.string.description1, R.drawable.mauryan, R.string.history1),
            Affirmation(R.string.affirmation2, R.string.description2, R.drawable.shunga, R.string.history2),
            Affirmation(R.string.affirmation3, R.string.description3, R.drawable.satyavahna, R.string.history3),
            Affirmation(R.string.affirmation4, R.string.description4,R.drawable.kushan,R.string.history4),
            Affirmation(R.string.affirmation5, R.string.description5,R.drawable.gupta, R.string.history5),
            Affirmation(R.string.affirmation6, R.string.description6,R.drawable.pallava, R.string.history6),
            Affirmation(R.string.affirmation7, R.string.description7,R.drawable.vakataka,R.string.history7),
            Affirmation(R.string.affirmation8, R.string.description8,R.drawable.pushyabhuti, R.string.history8),
            Affirmation(R.string.affirmation9, R.string.description9,R.drawable.chalukya, R.string.history9),
            Affirmation(R.string.affirmation10, R.string.description10,R.drawable.gurjara, R.string.history10),
            Affirmation(R.string.affirmation11,R.string.description11, R.drawable.pala, R.string.history11),
            Affirmation(R.string.affirmation12,R.string.description12, R.drawable.rashtrakuta, R.string.history12),
            Affirmation(R.string.affirmation13,R.string.description13, R.drawable.chola, R.string.history13),
            Affirmation(R.string.affirmation14,R.string.description14, R.drawable.mamluk, R.string.history14),
            Affirmation(R.string.affirmation15,R.string.description15, R.drawable.khilji, R.string.history15),
            Affirmation(R.string.affirmation16,R.string.description16, R.drawable.tughlaq, R.string.history16),
            Affirmation(R.string.affirmation17,R.string.description17, R.drawable.sayyid, R.string.history17),
            Affirmation(R.string.affirmation18,R.string.description18, R.drawable.lodhi, R.string.history18),
            Affirmation(R.string.affirmation19,R.string.description19, R.drawable.sangama, R.string.history19),
            Affirmation(R.string.affirmation20,R.string.description20, R.drawable.mughal, R.string.history20),
            Affirmation(R.string.affirmation21,R.string.description21, R.drawable.maratha, R.string.history21),
            )
    }
}