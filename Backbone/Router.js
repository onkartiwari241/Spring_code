var FirstView = Backbone.View.extend({

    el:"#content",
    initialize:function()
    {
        this.render();
    },
    render:function()
    {
        this.$el.html("This is first view");
    }
})

var SecondView = Backbone.View.extend({

    el:"#content",
    initialize:function()
    {
        this.render();
    },
    render:function()
    {
        this.$el.html("This is second view");
    }
})

var ThirdView = Backbone.View.extend({

    el:"#content",
    initialize:function()
    {
        this.render();
    },
    render:function()
    {
        this.$el.html("This is third view");
    }
})

var myRouter = Backbone.Router.extend({
    
    routes:{
        "":"ShowView1",
        // "view2":"ShowView2",
        // "view3":"ShowView3",
        "view2(/:recievIdForView2)":"ShowView2",
        "view3(/:recievIdForView3/:message)":"ShowView3"
        
    },

    ShowView1:function()
    {
        //console.log("Step 1");

        var viewObj1 = new FirstView();
    },
    ShowView2:function(recievIdForView2)
    {
        console.log("Step 2 with id  =>  "+recievIdForView2);

       var viewObj2 = new SecondView();
    },
    ShowView3:function(recievIdForView3,message)
    {
         console.log("Step 3 with id  =>  "+recievIdForView3+"  and ==>  "+message);

        var viewObj3 = new ThirdView();
    }
})

var myRouterObj = new myRouter();

Backbone.history.start();

