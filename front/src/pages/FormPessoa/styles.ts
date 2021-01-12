import styled from 'styled-components';
import { shade } from 'polished';

export const Container = styled.div`
  height: 100vh;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  width: 100%;

  form {
    margin-top: 20px;
    width: 400px;

    button {
      width: 100%;
      background-color: #04d361;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.2s;

      &:hover {
        background: ${shade(0.2, '#04d301')};
      }
    }
  }
`;

export const Background = styled.div`
  flex: 1;
  background-size: cover;
  background-color: #E7DDDD;
`;

export const Title = styled.h1`
  justify-content: center;
  width: 319px;
  height: 8px;

  font-family: Roboto;
  font-style: normal;
  font-weight: normal;
  font-size: 24px;
  line-height: 18px;

  color: #000000;

`;

