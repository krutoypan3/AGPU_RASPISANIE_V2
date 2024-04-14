package ru.aom13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aom13.model.User
import ru.aom13.ui.theme.ArtikProjectV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikProjectV2Theme {
                Surface {
//                    ShowUser()
                }
            }
        }
    }
}


@Preview
@Composable
fun UsersPreview() {
    var isOpen by remember { mutableStateOf(false) }
    var openId by remember { mutableIntStateOf(0) }

    ArtikProjectV2Theme {
        Surface {
            Column {
                UserCard(
                    user = User(
                        name = "Елизавета",
                        photoResId = R.drawable.liza,
                        status = "Котлин это круто!",
                        followersCount = 9345876,
                        followingCount = 3,
                    ),
                    if (openId == 1) isOpen else false,
                    openClick = {
                        isOpen = if (openId == 1) {
                            !isOpen
                        } else {
                            true
                        }
                        openId = 1
                    }
                )
                UserCard(
                    user = User(
                        name = "Владислав",
                        photoResId = R.drawable.vlad,
                        status = "Что такое компост? Я не понимаю, помогите пожалуйста...",
                        followersCount = 777,
                        followingCount = 65,
                    ),
                    if (openId == 2) isOpen else false,
                    openClick = {
                        isOpen = if (openId == 2) {
                            !isOpen
                        } else {
                            true
                        }
                        openId = 2
                    }
                )
                UserCard(
                    user = User(
                        name = "Эдгар",
                        photoResId = R.drawable.ed,
                        status = "ЫЫЫ, мама, я в телеке!!! Всем привеееееееет!!!!!!",
                        followersCount = 333,
                        followingCount = 42,
                    ),
                    if (openId == 3) isOpen else false,
                    openClick = {
                        isOpen = if (openId == 3) {
                            !isOpen
                        } else {
                            true
                        }
                        openId = 3
                    }
                )
                UserCard(
                    user = User(
                        name = "Артем",
                        photoResId = R.drawable.artem,
                        status = "Хелп ми плез",
                        followersCount = 6351,
                        followingCount = 128,
                    ),
                    if (openId == 4) isOpen else false,
                    openClick = {
                        isOpen = if (openId == 4) {
                            !isOpen
                        } else {
                            true
                        }
                        openId = 4
                    }
                )
            }
        }
    }
}

@Composable
fun UserCard(user: User, isOpen: Boolean, openClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .animateContentSize()
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable { openClick() }
            .background(
                color = if (isOpen) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(10.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = user.photoResId),
            modifier = Modifier
                .padding(5.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                .size(80.dp),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = user.name,
                maxLines = if (isOpen) 10 else 1,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = user.status,
                maxLines = if (isOpen) 10 else 2,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Подписчиков: ${user.followersCount}",
                maxLines = if (isOpen) 10 else 2,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Подписок: ${user.followingCount}",
                maxLines = if (isOpen) 10 else 3,
                style = MaterialTheme.typography.titleSmall,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


/**
 * начало было фиговое
 * функции для экранов наверное будут

@Composable
fun Screen1(user : User) {

}

@Composable
fun Screen2() {

}
*/
@Preview
@Composable
private fun BottomNavigation(modifier: Modifier = Modifier){
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = "Профиль")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
            label = {
                Text(text = "Что-то ещё")
            },
            selected = false,
            onClick = {}
        )
    }
}


