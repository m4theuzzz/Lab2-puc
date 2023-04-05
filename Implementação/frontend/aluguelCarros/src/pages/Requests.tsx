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
import NavBar from "../components/NavBar";
import useModal from "../hooks/useModal";
import Modal from "../components/Modal";

const carsmock = [1, 2, 3, 45, 6];

const Requests = () => {
  const [requests, setRequests] = useState([]);

  const requestModal = useModal();

  useEffect(() => {
    const getRequests = async () => {
      const rents = (await axios.get('https://localhost:8080/rents')).data;

      setRequests(rents);
    };

    getRequests();
  }, []);

  return (
    <Grid>
      <NavBar pageName={"Pedidos de Aluguel"} />
      <Grid container spacing={5} sx={{ p: 5 }}>
        {/* <Modal
          open={requestModal.isOpen}
          close={requestModal.close}
          title={"Fazer pedido de aluguel"}
        >
          Tem certeza que deseja realizar um pedido para{" "}
          {requestModal.elementClicked.id} ?
          <Button onClick={requestModal.close}>Cancelar</Button>
          <Button onClick={handleRentCar}>Confirmar</Button>
        </Modal> */}
        {carsmock.map((car) => (
          <Grid item>
            <BasicCard />
          </Grid>
        ))}
      </Grid>
    </Grid>
  );
};

export default Requests;
