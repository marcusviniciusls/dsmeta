import icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import axios from "axios";
import './style.css'
import { toast } from 'react-toastify';

type Props = {
    saleId: number
}

function handleClick(saleId: number){
    axios(`${BASE_URL}/sale/${saleId}/notification`).then(response => {
        toast.info("SMS Enviado com Sucesso");
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
  }
  
  export default NotificationButton
  