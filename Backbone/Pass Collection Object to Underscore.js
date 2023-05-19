var myModel = Backbone.Model.extend({
    defults:{
        name:'abc',
        age:22,
        address:'xyz',
    }
});

var m1 = new myModel({
    name:'Onkar Tiwari',
    age:22,
    address:'Ayodhya'
});

var m2 = new myModel({
    name:'Ankur Singh',
    age:23,
    address:'Ayodhya'
});

var m3 = new myModel({
    name:'Arpit Singh',
    age:22,
    address:'Ayodhya'
});

var myCollection = Backbone.Collection.extend({
    model:myModel,
});

var myCollectionObj = new myCollection([m1,m2,m3]);

var view = Backbone.View.extend({

    el:"#content",
    template:_.template($('#firstTemp').html()),
    Collection:myCollectionObj,

    initialize:function()
    {
        this.render();
    },
    render:function()
    {
        // _.each(this.Collection.toJSON(),function(model){
        //     console.log(model.name);
        // });

        this.$el.html(this.template({
            Collection:this.Collection.toJSON(),
        }));
    }
});

var viewObj = new view();