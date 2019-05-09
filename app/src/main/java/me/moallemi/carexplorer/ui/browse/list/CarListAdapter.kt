package me.moallemi.carexplorer.ui.browse.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.carexplorer.R
import me.moallemi.carexplorer.domain.model.Car
import me.moallemi.carexplorer.extension.load

class CarListAdapter(private val items: List<Car>) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_item, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = items[position]
        holder.bind(car)
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelName = itemView.findViewById<TextView>(R.id.modelName)
        private val info = itemView.findViewById<TextView>(R.id.info)
        private val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(car: Car) {
            modelName.text = car.modelName
            // TODO can be handled better e.g use "Auto" instead of "A" for transmission by using a mapper
            info.text = "${car.make} | ${car.transmission} | ${car.fuelType} | ${car.innerCleanliness}"
            image.load(car.carImageUrl, R.drawable.ic_directions_car_black_24dp)
        }
    }
}