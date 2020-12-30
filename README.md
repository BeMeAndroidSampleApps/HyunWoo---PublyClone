# PublyClone Project

## 주목할 코드
```
class CuratorTagAdapter :
    RecyclerView.Adapter<CuratorTagAdapter.CuratorTagViewHolder>() {
    private var dataList = mutableListOf<String>()

    inner class CuratorTagViewHolder(private val binding: ItemCuratorProfileTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tag: String) {
            binding.tag = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorTagViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCuratorProfileTagBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_curator_profile_tag,
            parent,
            false
        )
        return CuratorTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuratorTagViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(list: List<String>) {
        dataList = list.toMutableList()
        notifyDataSetChanged()
    }
}
```

- ``List``를 private으로 설정하여 일급 컬렉션으로 만들어 놓음
- DataBinding을 활용하여 onBind 함수를 간소화
- ``notifyDataSetChanged`` 함수를 호출할 때 내부에서 호출하는 방식으로 외부에서 실수로 바꿀 가능성을 원천 봉쇄
