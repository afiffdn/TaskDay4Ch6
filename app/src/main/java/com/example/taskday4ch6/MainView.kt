package com.example.taskday4ch6

interface MainView {
    // untuk menampilkan data yang di proses pada presenter
    fun showData(data:String)
    // untuk menampilkan toast
    fun showMessage(message:String)
    // untuk clear edit text
    fun clearField()
}