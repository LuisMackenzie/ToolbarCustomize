package com.mackenzie.toolbarcustomize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.ShareActionProvider
import android.widget.Toast
import androidx.core.view.MenuItemCompat
import com.mackenzie.toolbarcustomize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.toolbar.setTitle("Mackeeeen !")
        // binding.toolbar.setLogo()

        setSupportActionBar(binding.toolbar)

        binding.button.setOnClickListener {
            startActivity(Intent(this, PantallaDos::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val itemSearch = menu?.findItem(R.id.app_bar_search)
        val viewSearch = itemSearch?.actionView as SearchView
        /*val itemShare = menu?.findItem(R.id.b_share)
        val shareProvider = MenuItemCompat.getActionProvider(itemShare) as ShareActionProvider
        intentShare(shareProvider)*/

        viewSearch.queryHint = "your name?"
        viewSearch.setOnQueryTextFocusChangeListener { view, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }

        viewSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                Log.d("onQueryTextSubmit", newText.toString())
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                Log.d("onQueryTextChange", query.toString())
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun intentShare(provider: ShareActionProvider?) {
        if (provider == null) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            startActivity(intent)
        } else {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            provider.setShareIntent(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.b_fav -> {
                Toast.makeText(this, "Agregado a favoritos", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.b_share -> {
                Toast.makeText(this, "Compartiendo...", Toast.LENGTH_SHORT).show()
                intentShare(null)
                return true
            }
            R.id.b_settings -> {
                Toast.makeText(this, "Abriendo ajustes", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.app_bar_search -> {
                Toast.makeText(this, "Iniciando busqueda", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.b_exit -> {
                Toast.makeText(this, "Saliendo", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
            else -> {
                Toast.makeText(this, "Esto es una caso sin controlar", Toast.LENGTH_SHORT).show()
                // finish()
                return true
            }
        }
    }
}