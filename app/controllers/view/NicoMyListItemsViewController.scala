package controllers.view

import play.api._
import play.api.mvc._
import infrastructure.service.NicoAPIMyListItemsService
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class NicoMyListItemsViewController extends Controller {
  def show(id: Int) = Action {
    val myListItems = Await.result(NicoAPIMyListItemsService.get(id), Duration.Inf)
    Ok(views.html.nico_mylist_items("Nico MyLists!", myListItems))
  }
}
