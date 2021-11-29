package demo.collections.maps.items

class TreeMapItem(val value: Int): Comparable<TreeMapItem> {

    override fun hashCode(): Int {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeMapItem

        if (value != other.value) return false

        return true
    }

    override fun compareTo(other: TreeMapItem): Int {
        return value.compareTo(other.value)
    }

}