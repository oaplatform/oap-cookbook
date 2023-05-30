db.users.replaceOne(
    {"_id": "john@smith.com"},
    {
        "object": {
            "name" : "John Smith",
            "email" : "xenoss@xenoss.io",
        },
        "object:type": "user",
        "modified": new Date().getTime()
    },
    {"upsert": true}
);
