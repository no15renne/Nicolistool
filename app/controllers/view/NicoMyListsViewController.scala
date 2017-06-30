package controllers.view

import play.api._
import play.api.mvc._
import infrastructure.service.NicoAPIMyListsService
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class NicoMyListsViewController extends Controller {
  def show = Action {
    val myLists = Await.result(NicoAPIMyListsService.get(), Duration.Inf)
    Ok(views.html.nico_mylists("Nico MyLists Items!", myLists))
  }

  def hoge = Action {
    Ok(views.html.vuejs_test())
  }
}
