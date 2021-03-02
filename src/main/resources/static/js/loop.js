var myObject = new Vue({
    name: "Multi",
    el: '#multi',
    data() {
        return {
            items: []
        }
    },
    beforeMount() {
        this.getData();
    },
    methods: {
        async getData() {
            const res = await fetch('/api/list');
            const data = await res.json();
            console.log(data.data);
            this.items = data.data;
        }
    }
});