package com.example.taskday4ch6

import android.text.TextUtils

class MainPresenterImp(private val view: MainView):MainPresenter {
    private val ANGKA  = mutableListOf<Angka>()
    override fun addData(angkaPertama: String, angkaKedua: String) {
        if (TextUtils.isEmpty(angkaPertama) || TextUtils.isEmpty(angkaKedua))
        {
            view.showMessage("Field angka tidak boleh kosong")
        }
        else{
            val jumlah = angkaPertama + angkaKedua
            ANGKA.run {
                add(Angka(jumlah))
            }
            view.showMessage("Hasilnya adalah $jumlah")
            view.clearField()
        }
    }
    override fun clearHasil() {
        if(ANGKA.size != 0){
            ANGKA.clear()
            view.showMessage("Berhasil Dihapus")
        } else {
            view.showMessage("Data Emang Kosong Goblog!!!")
        }
    }

    override fun loadData() {
        if (ANGKA.size == 0){
            view.showMessage("data kosong")
        }
        else{
            var allData = ""

            for(i in 0 until ANGKA.size){
                allData += "Hasil : " + ANGKA[i].hasil + "\n\n"
            }

            allData += "Total : " + ANGKA.size

            view.showData(allData)
        }
    }
}