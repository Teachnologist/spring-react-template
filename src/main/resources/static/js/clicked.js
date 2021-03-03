var myObject = new Vue({
    name: "clickBody",
    el: '#clickbody',
    data() {
        return {
            items: []
        }
    },
    methods: {
        async getData() {
            const res = await fetch('/api/list');
            const data = await res.json();
            console.log(data.data);
            this.items = data.data;
        },
        clicked(){
            alert("clicked!");
        }
    }
});