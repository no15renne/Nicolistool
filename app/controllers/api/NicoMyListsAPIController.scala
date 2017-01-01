package controllers.api

import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL._
import play.api._
import play.api.mvc._
import com.ning.http.client.cookie.Cookie
import domain.entity.NicoMyList
import infrastructure.service.NicoAPIMyListsService

class NicoMyListsAPIController extends AbstractNicoMyListsAPIController {}


abstract class AbstractNicoMyListsAPIController extends Controller {
  def read = Action.async {
    implicit val writeFormats = Serialization.formats(NoTypeHints)
    for {
      myListGroups <- NicoAPIMyListsService.get()
    } yield Ok(Serialization.write(myListGroups))
  }
}
