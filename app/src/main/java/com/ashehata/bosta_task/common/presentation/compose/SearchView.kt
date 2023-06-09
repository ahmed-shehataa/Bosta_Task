package com.ashehata.bosta_task.common.presentation.compose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashehata.bosta_task.R

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    onSearch: (String) -> Unit
) {

    val trailingIconView = @Composable {
        Icon(
            Icons.Default.Close,
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    state.value = TextFieldValue()
                    onSearch("")
                }
                .padding(8.dp)
        )
    }

    Log.i("SearchView: ", state.value.text.trim().isNotEmpty().toString())
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
            onSearch(state.value.text)
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_images),
                style = MaterialTheme.typography.button.copy(
                    color = MaterialTheme.colors.onSecondary
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = if (state.value.text.trim().isNotEmpty()) trailingIconView else null,
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.Black,
            backgroundColor = Color.Gray.copy(alpha = 0.5f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
