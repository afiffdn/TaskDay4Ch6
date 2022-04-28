package com.example.taskday4ch6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.taskday4ch6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainView {
    private lateinit var presenterImp: MainPresenterImp
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = MainPresenterImp(this)

        binding.btnResult.setOnClickListener {
            presenterImp.addData(
                binding.etAngkaPertama.text.toString(),
                binding.angkaKedua.text.toString()
            )
        }
        binding.btnShow.setOnClickListener {
            presenterImp.loadData()
        }
    }
    override fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    override fun showData(data: String) {
        AlertDialog
            .Builder(this)
            .setNegativeButton("Close"){dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("Hapus Data"){dialog, _ ->
                //confirm
                AlertDialog.Builder(this)
                    .setPositiveButton("Iya"){dialog, _ ->
                        presenterImp.clearHasil()
                        dialog.dismiss()
                    }
                    .setNegativeButton("Tidak"){dialog, _ ->
                        dialog.dismiss()
                    }
                    .setTitle("Konfirmasi")
                    .setMessage("Yakin ingin Hapus Riwayat?")
                    .create()
                    .show()

                dialog.dismiss()
            }
            .setTitle("History")
            .setMessage(data)
            .create()
            .show()
    }
    override fun clearField(){
        binding.etAngkaPertama.text.clear()
        binding.angkaKedua.text.clear()
    }
}