package ru.aom13

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.aom13.ui.theme.ArtikProjectV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikProjectV2Theme {
                Surface {
                    ShowMyPreview()
                }
            }
        }
    }
}

class Human(
    /**
     * Попытка - 8
     * И, да, да, да. Я до сих пор нищий
     */
    var age: Int,
    var name: String,
    var height: Int,    // Рост в см
    var photo: Int,     // ID фото в ресурсах
)

@Composable
fun ShowHuman(human: Human) {
    var isOpen by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .clip(CircleShape)
            .animateContentSize()
            .padding(10.dp)
            .clickable { isOpen = !isOpen }
            .background(
                color = if (isOpen) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Image(
            painter = painterResource(id = human.photo),
            modifier = Modifier
                .padding(end = 5.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                .size(24.dp),
            contentDescription = "asdasdas"

        )
        Text(
            text = "${human.name}: ${human.age} лет, ${human.height} см",
            maxLines = if (isOpen) 10 else 1,
            style = MaterialTheme.typography.titleSmall
        )
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun ShowMyPreview() {
    ArtikProjectV2Theme {
        Surface {
            Column {
                ShowHuman(human = Human(18, "Antonina Sergeevna Sergeevna Sergeevna", 187, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela\nПривет\nя сдвинулся", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
                ShowHuman(human = Human(21, "Angela", 145, R.drawable.ic_launcher_background))
            }
        }
    }
}

