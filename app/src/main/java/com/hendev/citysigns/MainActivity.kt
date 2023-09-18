package com.hendev.citysigns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hendev.citysigns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landMarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        assignAndStart()
    }

    private fun assignAndStart() {
        createInit()
        createData();
        createAdapter();
    }

    private fun createInit() {
        landMarkList = ArrayList<Landmark>()
    }

    private fun createData() {
        val eiffel = Landmark(
            "Eiffel Tower",
            "Paris",
            R.drawable.eifel,
            "Eyfel Kulesi, Paris'teki demir kule. Kule, aynı zamanda tüm dünyada Fransa'nın sembolü halini almıştır. İsmini, inşa ettiren Fransız mimar Gustave Eiffel'den alır. En büyük turizm cazibelerinden biri olan Eyfel Kulesi, yılda 6 milyon turist çeker. 2002 yılında toplam ziyaretçi sayısı 200 milyona ulaşmıştır. "
        )
        val bigben = Landmark(
            "Big Ben",
            "London",
            R.drawable.bigben,
            "Big Ben, Londra'da Westminster Sarayı'nın yanındaki ünlü saat kulesi. Dünyanın en büyük ikinci dört yüzlü saatidir. \"Big Ben\" aslında saat kulesinin çanının adıdır, ancak zamanla halk tarafından tüm yapıyı belirtmek için kullanılır olmuştur."
        )
        val colosseum = Landmark(
            "Colosseum",
            "Rome",
            R.drawable.collesium,
            "Kolezyum ya da Flavianus Amfitiyatrosu, İtalya'nın başkenti Roma'da bulunan oval bir amfitiyatrodur. Usta bir komutan olan Vespasianus tarafından MS 72 yılında yapımına başlanıp MS 80 yılında Titus döneminde tamamlandı. Daha sonraki değişiklikler Domitian hükümdarlığı zamanında yapıldı."
        )
        val efes = Landmark(
            "Efes Harabeleri",
            "Izmir",
            R.drawable.efes,
            "Efes, Anadolu'nun batı kıyısında, bugünkü İzmir ilinin Selçuk ilçesinin üç kilometre güneybatısında yer alan antik bir Luvi şehriydi. Şehir Anadolu'da Yunan sömürgeciliğinin başlamasıyla birlikte İyonya ve daha sonra Roma dönemlerinde de önemini korumuştur. Kuruluşu Cilalı Taş Devri'ne yani MÖ 6000 yıllarına dayanır."
        )
        val galata = Landmark(
            "Galata Kulesi",
            "Istanbul",
            R.drawable.galata,
            "Galata Kulesi ya da müze olarak kullanılmaya başlaması sonrasındaki adıyla Galata Kulesi Müzesi, İstanbul'un Beyoğlu ilçesinde bulunan bir kuledir. Adını, bulunduğu Galata semtinden alır."
        )

        landMarkList.add(eiffel);
        landMarkList.add(bigben);
        landMarkList.add(colosseum);
        landMarkList.add(efes);
        landMarkList.add(galata);
    }

    private fun createAdapter() {
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, landMarkList.map { it.name })
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { a, v, i, l ->
                println("Item Clicked")
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("landmark", landMarkList[i])
                startActivity(intent)
                println("Click Data \na:$a \nv:$v \ni:$i \nl:$l")
            }
    }

    fun goToRecycleView(view: View) {
        val intent = Intent(this, RecycleActivity::class.java)
        intent.putExtra("landmarkList", landMarkList)
        startActivity(intent)
    }
}