import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

import controllers.NicoAPIMyListGroupsController

class NicoAPIMyListGroupsControllerSpec extends PlaySpec with OneAppPerTest {
  "Read" should {
    "get user's mylist" in {
      val home = route(app, FakeRequest(GET, "/api/v1/mylistgroups")).get
      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")
      contentAsString(home) must include ("user_id")
    }
  }
}
