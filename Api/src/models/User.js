module.exports = (sequelize, DataTypes) => {
  return sequelize.define("User", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    numero: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: { msg: "Le numero d'inscription ne peut pas etre vide." },
        notNull: { msg: "Le numero d'inscription est une proptiete requise." },
      },
    },
    password: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: { msg: "Le mot de passe ne peut pas etre vide." },
        notNull: { msg: "Le mot de passe est une proptiete requise." },
      },
    },
  });
};
