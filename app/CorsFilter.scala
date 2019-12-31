/**
  * set cors
  * allows access all domain
  * @see https://www.playframework.com/documentation/ja/2.4.x/CorsFilter
  */
import javax.inject.Inject

import play.api.http.HttpFilters
import play.filters.cors.CORSFilter

class Filters @Inject() (corsFilter: CORSFilter) extends HttpFilters {
  def filters = Seq(corsFilter)
}