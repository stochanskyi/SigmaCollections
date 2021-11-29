package demo.collections.maps.items

class MapItem(val value: Int): Comparable<MapItem> {

    override fun compareTo(other: MapItem): Int {
        return value.compareTo(other.value)
    }

}