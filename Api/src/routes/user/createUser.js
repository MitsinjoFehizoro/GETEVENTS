const { User } = require("../../db/sequelize");
const { ValidationError } = require("sequelize");

module.exports = (app) => {
  app.post("/get/users", (req, res) => {
    User.create({
      numero: req.body.numero,
      password: req.body.password,
    }).then((user) => {
        const message = "Creation d'un utilisateur avec succes"
        res.json({
            message : message,
            data : {
                id : user.id,
                numero : user.numero,
                password : user.password
            }
        })
    })
    .catch(error=>{
        if (error instanceof ValidationError) {
            res.status(400).json({message : error.message})
        } else {
            const message =
            "Erreur de la creation d'un utilisateur. Reessayer dans quelques instants.";
          res.status(500).json({ message });
        }
    })
  })
};
