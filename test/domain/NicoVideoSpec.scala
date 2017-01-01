import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._

import domain.entity.NicoVideo

class NicoVideoSpec extends PlaySpec with OneAppPerTest {
  "NicoVideo" should {
    "Jsonに変換できる" in {
      val video = NicoVideo("1", "title", "thumbnail_url")
      val videojs = Json.obj(
        "video_id" -> "1",
        "title" -> "title",
        "thumbnail_url" -> "thumbnail_url"
      )
      Json.toJson(video) mustBe videojs
    }
    "Jsonから構築できる" in {
      val video = NicoVideo("1", "title", "thumbnail_url")
      val videojs = Json.obj(
        "video_id" -> "1",
        "title" -> "title",
        "thumbnail_url" -> "thumbnail_url"
      )
      Json.fromJson[NicoVideo](videojs) mustBe JsSuccess(video)
    }
  }
}
