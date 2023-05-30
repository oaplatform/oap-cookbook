db.users.find().forEach(function(u) {
    db.users.update({_id: u._id}, {
        $set: {
            "object.firstName": u.object.name != null ? name.split(" ")[0] : null,
            "object.lastName": u.object.name != null ? name.split(" ")[1] : null
        }
    });
});
