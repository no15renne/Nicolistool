package controllers.api

import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._
import infrastructure.service.NicoAPIMyListItemsService

class FilteredNicoMyListItemsAPIController extends AbstractFilteredNicoMyListItemsAPIController {}

abstract class AbstractFilteredNicoMyListItemsAPIController extends Controller {
  def read(id: Int) = Action.async {
    implicit val writeFormats = Serialization.formats(NoTypeHints)
    for {
      myListItems <- NicoAPIMyListItemsService.get(id)
    } yield Ok(Serialization.write(myListItems))
  }
}
