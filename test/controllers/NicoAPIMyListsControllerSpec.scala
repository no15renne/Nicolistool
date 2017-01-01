import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

import controllers.NicoAPIMyListGroupsController

class NicoAPIMyListsControllerSpec extends PlaySpec with OneAppPerTest {
  "Read" should {
    "get deflist items" in {
      val home = route(app, FakeRequest(GET, "/api/v1/mylist/0/items")).get
      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")
      contentAsString(home) must include ("title")
    }
  }
}
