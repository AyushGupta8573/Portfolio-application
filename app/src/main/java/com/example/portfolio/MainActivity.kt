package com.example.portfolio

import android.app.Application
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Portfolio(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Portfolio(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        val isOpen = remember{ mutableStateOf(false) }
        Surface(
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)


        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image_1),
                    contentDescription =null,
                    modifier = Modifier
                        .size(60.dp)
                )
                Spacer(
                    modifier = Modifier
                        .padding(4.dp)
                )
                Divider()
                Spacer(
                    modifier = Modifier
                        .padding(4.dp)
                )
                Text(
                    text = "Ayush Gupta",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                    )
                )
                Spacer(
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = "ANDROID COMPOSE DEVELOPER",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif
                    )
                )
                Spacer(
                    modifier = Modifier.padding(2.dp)
                )
                Row(

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.instagram_image_1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = "__ayush7245gupta",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(8.dp),
                        fontFamily = FontFamily.Serif
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.github_image_1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = " AyushGupta8573 ",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(8.dp),
                        fontFamily = FontFamily.Serif
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.youtube_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = "     RAWxFear      ",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(8.dp),
                        fontFamily = FontFamily.Serif
                    )
                }
                Button(onClick = { isOpen.value = !isOpen.value }) {
                    Text(
                        text = "MY PROJECT",
                        fontFamily = FontFamily.Serif
                    )
                }
                if (isOpen.value) {
                    LazyColumn {
                        items(getProjectList()) {
                            ProjectItem(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image_1),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(
            modifier = Modifier.padding(8.dp)
        )
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(
                text = project.name,
                style = MaterialTheme.typography.bodySmall,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = project.desc,
                style = MaterialTheme.typography.bodySmall,
                fontFamily = FontFamily.Serif,
                fontSize = 10.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PortfolioPreview() {
    Portfolio()
}

data class Project(
    val name: String,
    val desc: String,
)

fun getProjectList(): List<Project> {
    return listOf(
        Project(
            name = "ToDo List",
            desc = "Listing Daily ToDo works"
        ),
        Project(
            name = "Portfolio",
            desc = "My Introductory Page"
        ),
        Project(
            name = "Pizza Application",
            desc = "Ordering Pizza"
        ),
        Project(
            name = "FireBase",
            desc = "Login to Google Account using FireBase"
        ),
        Project(
            name = "Weather Appliaction",
            desc = "Taking data of weather from internet"
        ),
        Project(
            name = "Compose Mvvm",
            desc = "Learning about Mvvm"
        ),
        Project(
            name = "My First Application",
            desc = "Basic Knowledge related to jetpack"
        ),
        Project(
            name = "Login UI Application",
            desc = "Learning about Animations"
        ),
    )
}