Vue.component("nico-mylist", {
  props: ["ml"],
  data: function() {
    return {
        htmlUrl: `http://localhost:9000/mylists/${this.ml.id}/items`
    }
  },
  template: "#nico-mylist",
  methods: {}
});

Vue.component("nico-mylists", {
  props: [],
  data: function() {
    return {
      title: "Nico MyLists Items!",
      fontStyle: {
          fontSize: "20px",
      },
      myLists: []
    }
  },
  created: function () {
    this.fetchData();
  },
  template: "#nico-mylists",
  methods: {
    fetchData: function() {
      // TODO: APIはMockやめる
      this.myLists = [{"id":"57888809","user_id":"63871305","name":"testnano","public":"0","default_sort":"1","create_time":1483031678,"update_time":1483031683,"sort_order":"2","icon_id":"0"},{"id":"57888808","user_id":"63871305","name":"公開test","public":"1","default_sort":"1","create_time":1483031660,"update_time":1483031676,"sort_order":"1","icon_id":"0"}];
      console.log(this.myLists);
    }
  }
});

var app = new Vue({
  el: '#app',
  data: {},
  methods: {}
})