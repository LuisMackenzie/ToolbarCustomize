package com.mackenzie.toolbarcustomize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mackenzie.toolbarcustomize.databinding.ActivityPantallaDosBinding

class PantallaDos : AppCompatActivity() {

    private lateinit var binding:ActivityPantallaDosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaDosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)*/



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.b_backup -> {
                Toast.makeText(this, "Agregado a favoritos", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.b_share2 -> {
                Toast.makeText(this, "Compartiendo...", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.b_settings2 -> {
                Toast.makeText(this, "Sonriendole a la vida", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.b_exit2 -> {
                Toast.makeText(this, "Saliendo ....", Toast.LENGTH_SHORT).show()
                return true
            }
            androidx.appcompat.R.id.home -> {
                Toast.makeText(this, "Volviendo ....", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
            else -> {
                Toast.makeText(this, "Esto no debveria de suceder nunca ...", Toast.LENGTH_SHORT).show()
                // finish()
                return true
            }
        }
    }
}