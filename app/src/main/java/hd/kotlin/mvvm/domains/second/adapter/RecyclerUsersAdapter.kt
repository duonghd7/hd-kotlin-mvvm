package hd.kotlin.mvvm.domains.second.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hd.kotlin.mvvm.R
import hd.kotlin.mvvm.models.responses.User

/**
 * Create on 2019-09-17
 * @author duonghd
 */

class RecyclerUsersAdapter : RecyclerView.Adapter<RecyclerUsersAdapter.ViewHolder>() {
    private val users = mutableListOf<User>()
    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_rcv_users, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)
        holder.tvId.text = user.id.toString()
        holder.tvUserName.text = user.name
        holder.uLine.visibility = if (position != users.size - 1) View.VISIBLE else View.INVISIBLE
        holder.itemView.setOnClickListener(View.OnClickListener {
            itemClickListener?.onClick(user)
        })
    }

    fun updateData(users: MutableList<User>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun setItemClickListener(itemClickListener: ItemClickListener?) {
        this.itemClickListener = itemClickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView
        val tvUserName: TextView
        val uLine: View

        init {
            tvId = itemView.findViewById(R.id.item_rcv_users_tv_id)
            tvUserName = itemView.findViewById(R.id.item_rcv_users_tv_username)
            uLine = itemView.findViewById(R.id.item_rcv_users_v_underline)
        }
    }

    interface ItemClickListener {
        fun onClick(user: User)
    }
}