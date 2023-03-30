import { Routes, Route, Outlet, Link } from "react-router-dom";
import Login from "./pages/Login";
import Requests from "./pages/Requests";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Requests />} />
        <Route path="login" element={<Login />} />
      </Route>
    </Routes>
  );
};

export default AppRoutes;

function Layout() {
  return (
    <div>
      <Outlet />
    </div>
  );
}
