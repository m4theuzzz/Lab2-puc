import {
  AppBar,
  Button,
  Grid,
  IconButton,
  Toolbar,
  Typography,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import BasicCard from "../components/Card";
import Modal from "../components/Modal";
import NavBar from "../components/NavBar";
import useModal from "../hooks/useModal";

const carsmock = [1, 2, 3, 45, 6];

const Cars = () => {
  const [cars, setCars] = useState([]);

  const carModal = useModal();

  useEffect(() => {
    const getCars = async () => {
      axios.get();

      setCars();
    };

    getCars();
  }, []);

  return (
    <Grid>
      <NavBar pageName={"Carros"} />
      <Grid container spacing={5} sx={{ p: 5 }}>
        <Modal
          open={carModal.isOpen}
          close={carModal.close}
          title={"Fazer pedido de aluguel"}
        >
          dwqwq
        </Modal>
        {carsmock.map((car) => (
          <Grid item>
            <BasicCard action={() => carModal.open()} />
          </Grid>
        ))}
      </Grid>
    </Grid>
  );
};

export default Cars;
