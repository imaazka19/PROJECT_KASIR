
package com.example.imaprojek2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NamaPembeli = findViewById<EditText>(R.id.txtNamaPembeli)
        val NamaBarang = findViewById<EditText>(R.id.txtNamaBarang)
        val JumlahBeli = findViewById<EditText>(R.id.txtJumlahBeli)
        val Harga = findViewById<EditText>(R.id.txtHarga)
        val UangBayar = findViewById<EditText>(R.id.txtUangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val TotalBelanja = findViewById<TextView>(R.id.txtTotalBelanja)
        val Kembalian = findViewById<TextView>(R.id.txtUangKembalian)
        val Bonus = findViewById<TextView>(R.id.txtBonus)
        val Keterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnResetData = findViewById<Button>(R.id.btnRisetData)



        btnProses.setOnClickListener {
            var total: Int = 0
            val jmlBeli = Integer.parseInt(JumlahBeli.text.toString())
            val hrg = Integer.parseInt(Harga.text.toString())
            val bayar = Integer.parseInt(UangBayar.text.toString())

            total = jmlBeli * hrg
            val kembali = bayar - total

           TotalBelanja.text = "Total Belanja :" + total.toString()
           Kembalian.text = "Uang Kembali: " + kembali.toString()

            if (bayar == total) {
                Keterangan.text = "Keterangan : Uang Pas"
            }
            if (bayar < total) {
                Keterangan.text = "Keterangan : Kurang Bayar" + abs(kembali)
            }
            if (bayar > total) {
                Keterangan.text = "Keterangan : Kembalian" + kembali
            }

            if (total >= 200000) {
                Bonus.text = "Bonus : Mouse"
            } else if (total >= 400000) {
                Bonus.text = "Bonus : Keyboard"
            } else if (total >= 600000) {
                Bonus.text = "Bonus : Harddisk"
            } else {
                Bonus.text = "Bonus : Tidak ada Bonus"
            }
        }


        btnResetData.setOnClickListener {
            NamaPembeli.setText("")
            NamaBarang.setText("")
            JumlahBeli.setText("")
            Harga.setText("")
            UangBayar.setText("")
            TotalBelanja.setText("Total Kembalian:")
            Kembalian.setText("Uang Kembali:")
            Bonus.setText("Bonus:")
            Keterangan.setText("Keterangan:")
        }
    }
}