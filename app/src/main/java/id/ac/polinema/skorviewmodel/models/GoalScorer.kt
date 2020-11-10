package id.ac.polinema.skorviewmodel.models

import android.os.Parcel
import android.os.Parcelable

open class GoalScorer : Parcelable {
    var name: String? = null
    var minute = 0

    constructor() {}
    constructor(name: String?, minute: Int) {
        this.name = name
        this.minute = minute
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(minute)
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        minute = `in`.readInt()
    }

    override fun toString(): String {
        return "GoalScorer{" +
                "name='" + name + '\'' +
                ", minute=" + minute +
                '}'
    }

    companion object {
        val CREATOR: Parcelable.Creator<GoalScorer> = object: Parcelable.Creator<GoalScorer> {
            override fun createFromParcel(source: Parcel): GoalScorer? {
                return GoalScorer(source)
            }

            override fun newArray(size: Int): Array<GoalScorer?> {
                return arrayOfNulls(size)
            }
        }
    }
}