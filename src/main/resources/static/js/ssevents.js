var myObject = new Vue({
    name: "SSE",
    el: '#sse',
    data() {
        return {
            sse: null,
            text: "date coming...",
            address: "http://localhost:8080"
        }
    },
    methods: {
        stopStream(){
            this.sse.close();
            this.text = "Event was closed";
        },
        startStream(){
            console.log("STARTING EVENTS");
            // Not a real URL, just using for demo purposes
            this.sse = new EventSource(this.address+'/sse/test');

            this.sse.addEventListener('message', event => {
                let data = JSON.parse(event.data);
                console.dir(data);
                this.text = data.text;
                 // stop retry

            }, false);

            this.sse.addEventListener('error', event => {
                if (event.readyState == EventSource.CLOSED) {
                    this.text = "Event has error";
                }
            }, false);
        }
    }
});
