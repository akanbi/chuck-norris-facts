package com.akanbi.chucknorris.presentation.util

val gifList = arrayListOf(
    "https://media0.giphy.com/media/d2jfPv6CUzpopfLa/giphy.gif",
    "https://images.uncyc.org/commons/thumb/0/08/ChuckApproves.gif/250px-ChuckApproves.gif",
    "https://media1.tenor.com/images/00ae7fd2b2acbdc7b36600c73941ec6a/tenor.gif",
    "https://media3.giphy.com/media/7qZ3ZX1Gu3TZm/source.gif",
    "https://img.izismile.com/img/img13/20200311/gifs/chuck_norris_approves_these_chuck_norris_80th_birthday_facts_16.gif",
    "https://i.gifer.com/2Xp.gif"
)

fun randomGif(): String = gifList.random()
