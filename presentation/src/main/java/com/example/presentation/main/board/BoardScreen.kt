package com.example.presentation.main.board

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.model.main.board.BoardCardModel
import com.example.presentation.theme.ConnectedTheme

@Composable
fun BoardScreen(
    boardCardModels: List<BoardCardModel>,
    onOptionClick: (BoardCardModel) -> Unit,
    onReplyClick: (BoardCardModel) -> Unit
) {
    Surface {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = boardCardModels.size,
                key = { index -> boardCardModels[index].boardId },
            ) {index ->
                val boardCardModel = boardCardModels[index]
                BoardCard(
                    username = boardCardModel.username,
                    images = boardCardModel.images,
                    text = boardCardModel.text,
                    onOptionClick = { onOptionClick(boardCardModel) },
                    onReplyClick = { onReplyClick(boardCardModel) }
                )
            }


        }
    }
}

@Preview
@Composable
fun BoardScreenPreview() {
    ConnectedTheme {
        BoardScreen(
            boardCardModels = listOf(
                BoardCardModel(
                    boardId = 1,
                    username = "aaaaa",
                    images = listOf(),
                    text = "aaaaa"
                ),
                BoardCardModel(
                    boardId = 2,
                    username = "aaaaa",
                    images = listOf(),
                    text = "aaaaa"
                ),
                BoardCardModel(
                    boardId = 3,
                    username = "aaaaa",
                    images = listOf(),
                    text = "aaaaa"
                ),
            ),
            onOptionClick = {},
            onReplyClick = {}
        )
    }
}