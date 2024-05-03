const { User } = require("../../db/sequelize");

module.exports = (app) => {
  app.get("/get/users/:numero", (req, res) => {
    User.findOne({
        where : {
            numero : req.params.numero
        }
    }).then((user) => {
      if (user) {
        const message = "Recuperation avec succes d'un utilisateur.";
        res.json({
          message: message,
          data: {
            id: user.id,
            numero: user.numero,
            password: user.password,
          },
        });
      } else {
        const message = "Utilisateur non trouve.";
        res.status(404).json({ message });
      }
    })
    .catch((error) => {
        const message =
          "Erreur de la recuperation d'un utilisateur. Reessayer dans quelques instants.";
        res.status(500).json({ message });
      });
  });
};
