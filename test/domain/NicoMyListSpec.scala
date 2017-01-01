import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._

import domain.entity.NicoMyList

class NicoMyListSpec extends PlaySpec with OneAppPerTest {
  "NicoMyList" should {
    "Jsonに変換できる" in {
      val mylist = NicoMyList("1", "2", "hoge", "0", "0", 0, 0, "0", "0")
      val mylistjs = Json.obj(
        "id" -> "1",
        "user_id" -> "2",
        "name" -> "hoge",
        "public" -> "0",
        "default_sort" -> "0",
        "create_time" -> 0L,
        "update_time" -> 0L,
        "sort_order" -> "0",
        "icon_id" -> "0"
      )
      Json.toJson(mylist) mustBe mylistjs
    }
    "Jsonから構築できる" in {
      val mylist = NicoMyList("1", "2", "hoge", "0", "0", 0, 0, "0", "0")
      val mylistjs = Json.obj(
        "id" -> "1",
        "user_id" -> "2",
        "name" -> "hoge",
        "public" -> "0",
        "default_sort" -> "0",
        "create_time" -> 0L,
        "update_time" -> 0L,
        "sort_order" -> "0",
        "icon_id" -> "0"
      )
      Json.fromJson[NicoMyList](mylistjs) mustBe JsSuccess(mylist)
    }
  }
}
