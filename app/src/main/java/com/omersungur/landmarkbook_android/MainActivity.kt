package com.omersungur.landmarkbook_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.omersungur.landmarkbook_android.databinding.ActivityDetailsBinding
import com.omersungur.landmarkbook_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var landrmarkList : ArrayList<Landmark>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landrmarkList = ArrayList()

        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val colosseum = Landmark("Colosseum","Italy", R.drawable.colosseum)
        val eiffel = Landmark("Eiffel","France",R.drawable.eiffeltower)
        val londonBridge = Landmark("London Bridge","England",R.drawable.londonbridge)

        landrmarkList.add(pisa)
        landrmarkList.add(colosseum)
        landrmarkList.add(eiffel)
        landrmarkList.add(londonBridge)

        binding.recyclerView.layoutManager = LinearLayoutManager(this) // Recyclerview içindeki görünümlerin layoutunu ayarladık.
        val landmarkAdapter = LandmarkAdapter(landrmarkList) // Adapterümüz içerisine verilerimizin bulunduğu arraylisti gönderdik.
        binding.recyclerView.adapter = landmarkAdapter // recyclerView'un adapterünü ayarladık.
    }
}