package org.example.project.data

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)

val itemList = (1..10000).map{
    Item(
        id = it,
        title = "Item $it",
        description = "Description $it",
        imageUrl = "https://picsum.photos/200/300?random=$it"
    )
}
