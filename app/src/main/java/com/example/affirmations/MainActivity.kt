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
package com.example.affirmations
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {



                Surface(color = Color(0xFFC9BB8E),
                modifier = Modifier.fillMaxSize()) {
                    FrontScreen()
                }
            }
        }
    }
}

@Composable
fun AffirmationApp() {
    AffirmationsTheme {
        AffirmationList(affirmationList = Datasource().loadAffirmations())
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        appTopBar()
    }
    )
    {
        LazyColumn {
            items(affirmationList) { affirmation ->
                AffirmationCard(affirmation)
            }
        }
    }
}
@Composable
private fun FrontScreenButton(
    tapped: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick,
    modifier = Modifier.fillMaxSize()) {
        Box() {
            Text(
                text = "Tap to continue...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 80.dp, top = 700.dp, bottom = 10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun FrontScreen(){
    var tapped by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        ){

        Image(painter =  painterResource(R.drawable.front_page_2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            contentScale = ContentScale.Crop)
        Text(text = "Rµlêr§ Ö£ Äñ¢ïêñ† ÌñÐïå",
            modifier = Modifier
                .padding(top = 250.dp )
                .fillMaxWidth(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            color = Color(0xFF34B371C),
            textAlign = TextAlign.Center
        )
        FrontScreenButton(tapped = tapped, onClick = { tapped = !tapped })
    }
    if (tapped) {
        AffirmationApp()

    }
}


@Composable
fun HistoryOfDynasty(@StringRes history_of_dynasty: Int,
                     modifier: Modifier = Modifier){

    var tap by remember {
        mutableStateOf(false)
    }

    //Surface( color = Color(0xFFEEDC9A)) {
        Surface( color = MaterialTheme.colors.primaryVariant) {

        Column(
            modifier = modifier.padding(
                start = 16.dp,
                top = 10.dp,
                bottom = 10.dp,
                end = 16.dp
            )
        ) {
            Row() {
                Text(
                    text = "About : ",
                    style = MaterialTheme.typography.h5,
                    color = Color(0xFF80471C),
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.weight(1f))
                ImpButton(tap = tap, onClick = { tap = !tap })
            }
            Text(
                text = stringResource(id = history_of_dynasty),
                style = MaterialTheme.typography.body2,
                color = Color(0xFF80471C),
            )
        }
    }
}

@Composable
private fun InfoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.expand_button_content_description)
        )
    }
}

@Composable
private fun ImpButton(
    tap: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if(tap) Icons.Filled.Star else Icons.Filled.StarBorder,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.expand_button_content_description)
        )

    }
}
@Composable
fun appTopBar(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colors.primaryVariant) {
        Text(
            text = "HISTORY OF INDIA",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            color = Color(0xFF795C34),
            textAlign = TextAlign.Center

        )
    }
}
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Surface(color = Color(0xFFFDEFB2)) {

        Card(modifier = Modifier.padding(16.dp), elevation = 4.dp) {
            Surface(color = Color(0xFFFBE790)) {

               Column (
                   modifier = Modifier.animateContentSize(
                       animationSpec = spring(
                           dampingRatio = Spring.DampingRatioMediumBouncy,
                           stiffness = Spring.StiffnessLow
                       )
                   )
                       ){

                    Row {
                        Image(
                            painter = painterResource(affirmation.imageId),
                            contentDescription = stringResource(affirmation.stringResourceId),
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp)
                                .padding(16.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column() {
                            Text(
                                text = LocalContext.current.getString(affirmation.stringResourceId),
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                fontSize = 25.sp,
                                style = MaterialTheme.typography.h6,
                                color = Color(0xFF9A7B4F),
                                fontWeight = FontWeight.Bold
                            )


                                Text(
                                    LocalContext.current.getString(affirmation.descriptionId),
                                    modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
                                    style = MaterialTheme.typography.body1,
                                    color = Color(0xFF4B371C)
                                )

                        }
                    }
                   Box(modifier = Modifier.padding(start = 150.dp)) {
                       InfoButton(
                           expanded = expanded, onClick = { expanded = !expanded }
                       )
                   }
                       if (expanded) {
                           HistoryOfDynasty(affirmation.historyId)
                       }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard (Affirmation(R.string.affirmation1, R.string.description1, R.drawable.sangama, R.string.history1))
}
