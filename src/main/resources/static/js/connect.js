'use strict';
function getData(url) {
    self=this;
    axios.get(url).then(ref=>{
        this.tables_data.data=ref.data;
    })
}