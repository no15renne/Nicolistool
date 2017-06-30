package infrastructure.service

import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL._
import play.api._
import play.api.mvc._
import com.ning.http.client.cookie.Cookie
import domain.entity.{NicoVideo, NicoMyList}

sealed class NicoAPIService {
  // TODO: userSessionはログイン叩くなりmylist叩くなりして取ってくる
  val userSession: String = "user_session_63871305_8881e045ead53ba75453000b377abd8201c709aeea94656e619e245ed7883aaa"

  // TODO: Tを指定したgetの抽象化を追加
  def connect(urlStr: String) = {
    val svc = url(urlStr).addCookie(
      new Cookie(
        "user_session",
        userSession,
        userSession,
        ".nicovideo.jp",
        "/",
        0,
        100,
        false,
        true
      )
    )
    Http(svc OK as.json4s.Json)
  }
}

object NicoAPIMyListItemsService extends NicoAPIService {
  def get(id: Int): Future[List[NicoVideo]] = {
    val urlStr = id match {
      case 0 => "http://www.nicovideo.jp/api/deflist/list"
      case x => s"http://www.nicovideo.jp/api/mylist/list?group_id=${id}"
    }

    for {
      c <- connect(urlStr)
    } yield {
      val myListItemJsons: List[JValue] = (c \ "mylistitem").asInstanceOf[JArray].arr
      val myListItems = myListItemJsons.map(obj => {
        NicoVideo.fromJson4s((obj \ "item_data"))
      })
      myListItems
    }
  }
}

object NicoAPIMyListsService extends NicoAPIService {
  def get(): Future[List[NicoMyList]] = {
    val urlStr = "http://www.nicovideo.jp/api/mylistgroup/list"

    for {
      c <- connect(urlStr)
    } yield {
      val myListGroupJsons: List[JValue] = (c \ "mylistgroup").asInstanceOf[JArray].arr
      val myListGroups = myListGroupJsons.map(NicoMyList.fromJson4s)
      myListGroups
    }
  }
}